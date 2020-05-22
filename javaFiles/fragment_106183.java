import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class TestImageDatbase {

    private Connection con;

    public static void main(String[] args) {
        new TestImageDatbase();
    }

    public TestImageDatbase() {
        try {
            clearDatabase();
            saveImage();
            loadImage();
        } catch (ClassNotFoundException | SQLException | IOException exp) {
            exp.printStackTrace();
        }
    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:d:\\Image", "sa", "");
    }

    protected void clearDatabase() throws IOException, ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement stmt = null;

        try {

            con = getConnection();
            System.out.println("Cleaning database");
            stmt = con.prepareStatement("delete from images");
            int updated = stmt.executeUpdate();
            System.out.println("Updated " + updated + " rows");

        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }

    protected void saveImage() throws IOException, ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;

        try {

            baos = new ByteArrayOutputStream();

            File source = new File("/path/to/file");
            System.out.println("Source size = " + source.length());
            BufferedImage img = ImageIO.read(source);
            ImageIO.write(img, "png", baos);

            baos.close();

            bais = new ByteArrayInputStream(baos.toByteArray());

            con = getConnection();
            stmt = con.prepareStatement("insert into images (image) values (?)");
            stmt.setBinaryStream(1, bais);
            int updated = stmt.executeUpdate();
            System.out.println("Updated " + updated + " rows");

        } finally {
            try {
                bais.close();
            } catch (Exception e) {
            }
            try {
                baos.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }

    protected void loadImage() throws IOException, ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            con = getConnection();
            stmt = con.prepareStatement("select image from images");
            rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println("Getting blob");
                Blob blob = rs.getBlob(1);
                System.out.println("Reading image");
                BufferedImage img = ImageIO.read(blob.getBinaryStream());
                System.out.println("img = " + img);
                JOptionPane.showMessageDialog(null, new JScrollPane(new JLabel(new ImageIcon(img))));

            }

        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }

}