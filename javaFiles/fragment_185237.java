import java.awt.*;

import javax.swing.*;

public class VerticalStackPanel extends JFrame
{

  public static void main( String[] args )
  {
    JFrame frame = new VerticalStackPanel();
   // frame.setSize( 800, 600 );
    frame.setVisible( true );
  }

  public VerticalStackPanel()
  {
    super();

    getContentPane().setLayout( new BorderLayout() );
    //final JComponent innerContainer = createInnerContainer();
    JScrollPane scrollPane = new JScrollPane(createTextArea());
    scrollPane.getVerticalScrollBar().setUnitIncrement( 16 );
    scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
    scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    getContentPane().add( scrollPane, BorderLayout.CENTER );
    pack();
  }

//  private JComponent createInnerContainer()
//  {
//    ScrollablePanel innerContainer = new ScrollablePanel();
//    BoxLayout layout = new BoxLayout( innerContainer, BoxLayout.Y_AXIS );//sets itself automagically.
//   // innerContainer.setLayout( layout );
//
//    innerContainer.add( createTextArea() );
//
//    return innerContainer;
//  }

  private Component createTextArea()
  {
    JTextArea textArea = new JTextArea();
    textArea.setText( "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In     vitae diam nunc. Proin vulputate, odio consectetur tincidunt aliquet, metus ipsum rhoncus tellus, in dignissim ligula tortor at risus. Aenean rhoncus lorem a magna luctus molestie. Fusce consequat enim vel quam pharetra varius. Vivamus porta condimentum orci non ultrices. Duis magna arcu, fringilla ut eleifend a, volutpat ac elit. Sed ligula enim, dictum id fringilla vitae, ornare vel nulla. Proin lobortis suscipit lectus eget placerat. Morbi aliquam dolor quis lectus tincidunt eu volutpat risus fermentum. Nunc et sapien a nisl aliquet auctor. Phasellus nec sem tellus, et scelerisque sapien. In a nibh vestibulum velit convallis sodales. Vestibulum tempor fringilla vulputate. Duis hendrerit dolor id urna aliquam cursus auctor enim pulvinar. Nulla rutrum fringilla eros, id congue nisi mattis in. Pellentesque consectetur eleifend mauris, ut aliquam purus convallis ac. Vestibulum pretium, sem at congue faucibus, leo leo volutpat odio, ut feugiat nulla felis a diam. Praesent dignissim eros ac eros semper auctor. Phasellus eu sapien nibh. Quisque pulvinar tristique lectus, quis porttitor purus suscipit sed. Curabitur gravida, ipsum ut vehicula aliquet, erat ipsum tincidunt nulla, eget bibendum felis dolor vel risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Phasellus vitae nisl odio, blandit laoreet nibh." );
    textArea.setLineWrap( true );
    textArea.setWrapStyleWord( true );
    textArea.setColumns(30);
    textArea.setRows(10);
    //textArea.setMinimumSize( new Dimension( 100, 100 ) );

    return textArea;
  }

  private static class ScrollablePanel extends JPanel implements Scrollable
  {
    public Dimension getPreferredScrollableViewportSize()
    {
      return super.getPreferredSize();
    }

    public int getScrollableUnitIncrement( Rectangle visibleRect, int orientation, int    direction )
    {
      return 16;
    }

    public int getScrollableBlockIncrement( Rectangle visibleRect, int orientation, int direction )
    {
      return 16;
    }

    public boolean getScrollableTracksViewportWidth()
    {
      return true;
    }

    public boolean getScrollableTracksViewportHeight()
    {
      return false;
    }

  }

}