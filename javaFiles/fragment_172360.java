import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProjectileShooterTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final ProjectileShooter projectileShooter = 
            new ProjectileShooter();
        final ProjectileShooterPanel projectileShooterPanel = 
            new ProjectileShooterPanel(projectileShooter);
        projectileShooter.setPaintingComponent(projectileShooterPanel);

        ProjectileShooterMouseControl mouseControl = 
            new ProjectileShooterMouseControl(
                projectileShooter, projectileShooterPanel);
        projectileShooterPanel.addMouseMotionListener(mouseControl);
        projectileShooterPanel.addMouseListener(mouseControl);

        JPanel controlPanel = new JPanel(new GridLayout(1,0));

        controlPanel.add(new JLabel("Angle: ", SwingConstants.RIGHT));
        final JSlider angleSlider = new JSlider(0, 180, 45);
        angleSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                int angleDeg = angleSlider.getValue();
                projectileShooter.setAngle(Math.toRadians(angleDeg));
            }
        });
        controlPanel.add(angleSlider);

        controlPanel.add(new JLabel("Power:", SwingConstants.RIGHT));
        final JSlider powerSlider = new JSlider(0, 50, 25);
        controlPanel.add(powerSlider);
        powerSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                int power = powerSlider.getValue();
                projectileShooter.setPower(power);
            }
        });

        JButton shootButton = new JButton("Shoot");
        shootButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                projectileShooter.shoot();
            }
        });
        controlPanel.add(shootButton);

        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(controlPanel, BorderLayout.NORTH);
        f.getContentPane().add(projectileShooterPanel, BorderLayout.CENTER);
        f.setSize(1200,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class ProjectileShooterMouseControl 
    implements MouseListener, MouseMotionListener
{
    private final ProjectileShooter projectileShooter;
    private final ProjectileShooterPanel projectileShooterPanel;

    private boolean draggingOrigin = false;
    private boolean draggingTarget = false;

    ProjectileShooterMouseControl(
        ProjectileShooter projectileShooter, 
        ProjectileShooterPanel projectileShooterPanel)
    {
        this.projectileShooter = projectileShooter;
        this.projectileShooterPanel = projectileShooterPanel;
    }

    private Point2D toWorld(Point2D screen)
    {
        return new Point2D.Double(screen.getX(), 
            projectileShooterPanel.getHeight() - screen.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        Point2D p = toWorld(e.getPoint());
        if (draggingOrigin)
        {
            projectileShooter.setOrigin(p);
        }
        else if (draggingTarget)
        {
            projectileShooter.setTarget(p);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        Point2D p = toWorld(e.getPoint());

        Point2D origin = projectileShooter.getOrigin();
        Point2D target = projectileShooter.getTarget();
        if (origin.distance(p) < 10)
        {
            draggingOrigin = true;
        }
        else if (target.distance(p) < 10)
        {
            draggingTarget = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        draggingOrigin = false;
        draggingTarget = false;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

}


class ProjectileShooter
{
    private static final double TIME_SCALE = 20;
    static final double GRAVITY = 9.81 * 0.1;

    private double angleRad = Math.toRadians(45);
    private double power = 25;

    private final Point2D origin = new Point2D.Double(50, 50);
    private final Point2D target = new Point2D.Double(500, 100);

    private Projectile projectile;
    private JComponent paintingComponent;

    void setPaintingComponent(JComponent paintingComponent)
    {
        this.paintingComponent = paintingComponent;
    }

    void setOrigin(Point2D origin)
    {
        this.origin.setLocation(origin);
        this.paintingComponent.repaint();
    }

    Point2D getOrigin()
    {
        return new Point2D.Double(origin.getX(), origin.getY());
    }

    void setTarget(Point2D target)
    {
        this.target.setLocation(target);
        this.paintingComponent.repaint();
    }

    Point2D getTarget()
    {
        return new Point2D.Double(target.getX(), target.getY());
    }

    void setAngle(double angleRad)
    {
        this.angleRad = angleRad;
        this.paintingComponent.repaint();
    }

    double getAngle()
    {
        return angleRad;
    }


    void setPower(double power)
    {
        this.power = power;
        this.paintingComponent.repaint();
    }

    double getPower()
    {
        return power;
    }

    double computeY(double x)
    {
        // http://de.wikipedia.org/wiki/Wurfparabel
        //  #Mathematische_Beschreibung
        double g = GRAVITY;
        double b = angleRad;
        double v0 = power;
        if (b > Math.PI / 2)
        {
            b = Math.PI - b;
        }
        double cb = Math.cos(b);
        return x * Math.tan(b) - g / (2 * v0 * v0 * cb * cb) * x * x;
    }

    double computeRange(double h0)
    {
        // http://de.wikipedia.org/wiki/Wurfparabel
        //  #Reichweite_bei_von_Null_verschiedener_Anfangsh.C3.B6he
        double g = GRAVITY;
        double b = angleRad;
        double v0 = power;
        double sb = Math.sin(b);
        double f0 =(v0 * v0) / (g + g) * Math.sin(b + b);
        double i = 1.0 + (2 * g * h0) / (v0 * v0 * sb * sb);
        double f1 = 1.0 + Math.sqrt(i);
        return f0 * f1;
    }

    Point2D computeRequiredAngles()
    {
        // http://en.wikipedia.org/wiki/Trajectory_of_a_projectile
        //  #Angle_required_to_hit_coordinate_.28x.2Cy.29
        double v0 = power;
        double g = GRAVITY;
        double vv = v0 * v0;
        double dx = target.getX() - origin.getX();
        double dy = target.getY() - origin.getY();
        double radicand = vv * vv - g * (g * dx * dx + 2 * dy * vv);
        double numerator0 = vv + Math.sqrt(radicand);
        double numerator1 = vv - Math.sqrt(radicand);
        double angle0 = Math.atan(numerator0 / (g*dx));
        double angle1 = Math.atan(numerator1 / (g*dx));
        return new Point2D.Double(angle0, angle1);
    }

    double computeRequiredPower()
    {
        // WolframAlpha told me so...
        double R = target.getX() - origin.getX();
        double h0 = origin.getY() - target.getY();
        double g = GRAVITY;
        double b = angleRad;
        double sb = Math.sin(b);
        double isb = 1.0 / sb;
        double v0 = 
            Math.sqrt(2) * Math.sqrt(g) * R * 
            Math.sqrt(1 / Math.sin(2*b)) /
            Math.sqrt(h0 * Math.sin(2*b) * isb * isb + 2*R);
        return v0;
    }



    void shoot()
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                executeShot();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private static Point2D polarToCartesian(
        Point2D polar, Point2D cartesian)
    {
        double x = Math.cos(polar.getX()) * polar.getY();
        double y = Math.sin(polar.getX()) * polar.getY();
        if (cartesian == null)
        {
            cartesian = new Point2D.Double();
        }
        cartesian.setLocation(x, y);
        return cartesian;
    }

    private void executeShot()
    {
        if (projectile != null)
        {
            return;
        }
        projectile = new Projectile();
        projectile.setPosition(origin);

        Point2D velocity = polarToCartesian(
            new Point2D.Double(angleRad, power), null); 
        projectile.setVelocity(velocity);

        long prevTime = System.nanoTime();
        while (projectile.getPosition().getY() >= 0)
        {
            long currentTime = System.nanoTime();
            double dt = TIME_SCALE * (currentTime - prevTime) / 1e9;
            projectile.performTimeStep(dt);

            prevTime = currentTime;
            paintingComponent.repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
        }

        projectile = null;
        paintingComponent.repaint();
    }

    Projectile getProjectile()
    {
        return projectile;
    }

}

class Projectile
{
    private static final Point2D ACCELERATION = 
        new Point2D.Double(0, -ProjectileShooter.GRAVITY);

    private final Point2D position = new Point2D.Double();
    private final Point2D velocity = new Point2D.Double();

    public Point2D getPosition()
    {
        return new Point2D.Double(position.getX(), position.getY());
    }
    public void setPosition(Point2D point)
    {
        position.setLocation(point);
    }

    public void setVelocity(Point2D point)
    {
        velocity.setLocation(point);
    }

    void performTimeStep(double dt)
    {
        scaleAddAssign(velocity, dt, ACCELERATION);
        scaleAddAssign(position, dt, velocity);

        //System.out.println("Now at "+position+" with "+velocity);
    }

    private static void scaleAddAssign(
        Point2D result, double factor, Point2D addend)
    {
        double x = result.getX() + factor * addend.getX();
        double y = result.getY() + factor * addend.getY();
        result.setLocation(x, y);
    }

}

class ProjectileShooterPanel extends JPanel
{
    private final ProjectileShooter projectileShooter;

    public ProjectileShooterPanel(ProjectileShooter projectileShooter)
    {
        this.projectileShooter = projectileShooter;
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        double angleDeg = Math.toDegrees(projectileShooter.getAngle());
        double power = projectileShooter.getPower();
        Point2D origin = projectileShooter.getOrigin();
        Point2D target = projectileShooter.getTarget();
        double range = projectileShooter.computeRange(origin.getY());
        double impactX = range+origin.getX();

        g.setColor(Color.BLACK);
        int textY = 20;

        g.drawString("Drag origin and target with mouse ", 10, textY+=16);
        g.drawString("Angle: "+angleDeg, 10, textY+=16);
        g.drawString("Power: "+power, 10, textY+=16);
        g.drawString("Range: "+range, 10, textY+=16);
        g.drawString("Origin: "+origin, 10, textY+=16);
        g.drawString("Impact: "+impactX, 10, textY+=16);
        g.drawString("Target: "+target, 10, textY+=16);

        Point2D requiredAngles = projectileShooter.computeRequiredAngles();
        double requiredAngleDeg0 = Math.toDegrees(requiredAngles.getX());
        double requiredAngleDeg1 = Math.toDegrees(requiredAngles.getY());
        g.drawString("Assuming fixed power:", 10, textY+=16);
        g.drawString("Required angle 0: "+requiredAngleDeg0, 10, textY+=16);
        g.drawString("Required angle 1: "+requiredAngleDeg1, 10, textY+=16);

        double requiredPower = projectileShooter.computeRequiredPower();
        g.drawString("Assuming fixed angle:", 10, textY+=16);
        g.drawString("Required power: "+requiredPower, 10, textY+=16);

        Projectile projectile = projectileShooter.getProjectile();
        if (projectile != null)
        {
            g.setColor(Color.RED);
            Point2D position = projectile.getPosition();
            int px = (int)position.getX();
            int py = getHeight() - (int)position.getY();
            g.fillOval(px-10, py-10, 20, 20);
        }

        g.setColor(Color.GREEN);
        int ox = (int)origin.getX();
        int oy = getHeight() - (int)origin.getY();
        g.fillOval(ox-10, oy-10, 20, 20);

        g.setColor(Color.BLUE);
        int tx = (int)target.getX();
        int ty = getHeight() - (int)target.getY();
        g.fillOval(tx-10, ty-10, 20, 20);

        g.setColor(Color.BLACK);
        g.drawLine((int)impactX, 0, (int)impactX, getHeight());

        g.setColor(Color.GRAY);

        Shape trajectory = createTrajectory(
            Math.min(origin.getX(), impactX),
            Math.max(origin.getX(), impactX));
        g.draw(trajectory);
    }

    private Shape createTrajectory(double x0, double x1)
    {
        Path2D path = new Path2D.Double();
        Point2D origin = projectileShooter.getOrigin();
        double y0 = projectileShooter.computeY(Math.abs(origin.getX()-x0));
        path.moveTo(x0, getHeight()-(y0+origin.getY()));
        for (double x=x0; x<=x1; x++)
        {
            double y = projectileShooter.computeY(Math.abs(origin.getX()-x));
            path.lineTo(x, getHeight()-(y+origin.getY()));
        }
        return path;
    }

}