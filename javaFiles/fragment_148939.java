package foo;

import javax.swing.*;
import java.awt.*;

public class ChangeIpSettingsDialog extends JDialog
{
public ChangeIpSettingsDialog( Frame owner )
{
    super( owner, true );
    setContentPane( createContent() );
}

private Container createContent()
{
    JPanel result = new JPanel();
    result.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    // Create the layout
    GroupLayout layout = new GroupLayout( result );
    result.setLayout( layout );
    layout.setAutoCreateGaps( true );

    // Create the components we will put in the form
    JLabel ipAddressLabel = new JLabel( "IP Address:" );
    JTextField ipAddressTextField = new JTextField( 20 );
    JLabel subnetLabel = new JLabel( "Subnet:" );
    JTextField subnetTextField = new JTextField( 20 );
    JLabel gatewayLabel = new JLabel( "Gateway:" );
    JTextField gatewayTextField = new JTextField( 20 );

    // Horizontally, we want to align the labels and the text fields
    // along the left (LEADING) edge
    layout.setHorizontalGroup( layout.createSequentialGroup()
                                       .addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
                                                          .addComponent( ipAddressLabel )
                                                          .addComponent( subnetLabel )
                                                          .addComponent( gatewayLabel ) )
                                       .addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
                                                          .addComponent( ipAddressTextField )
                                                          .addComponent( subnetTextField )
                                                          .addComponent( gatewayTextField ) )
    );

    // Vertically, we want to align each label with his textfield
    // on the baseline of the components
    layout.setVerticalGroup( layout.createSequentialGroup()
                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
                                                        .addComponent( ipAddressLabel )
                                                        .addComponent( ipAddressTextField ) )
                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
                                                        .addComponent( subnetLabel )
                                                        .addComponent( subnetTextField ) )
                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
                                                        .addComponent( gatewayLabel )
                                                        .addComponent( gatewayTextField ) )
    );

    return result;
}

public static void main( String[] args )
{
    ChangeIpSettingsDialog dialog = new ChangeIpSettingsDialog( null );
    dialog.pack();
    dialog.setVisible( true );
}
}