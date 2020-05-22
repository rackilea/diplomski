import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.sound.sampled.*;
import java.io.*;

class GetSoundsByFileType {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AudioFileFormat.Type[] formatTypes = AudioSystem.getAudioFileTypes();
                String[] types = new String[formatTypes.length];
                for(int ii=0; ii<types.length; ii++) {
                    types[ii] = formatTypes[ii].getExtension();
                }

                FileTypesFilter fileTypesFilter = new FileTypesFilter(types);
                // Just to confuse things, JFileChooser accepts a
                // different type of filter!
                FileNameExtensionFilter extensionFilter =
                    new FileNameExtensionFilter("Sound clips", types);
                JFileChooser fc = new JFileChooser();
                fc.setAcceptAllFileFilterUsed(false);
                fc.addChoosableFileFilter(extensionFilter);

                int result = fc.showOpenDialog(null);
                if (result==JFileChooser.APPROVE_OPTION) {
                    File startAt = fc.getSelectedFile();

                    startAt = startAt.getParentFile();
                    File[] files = startAt.listFiles(fileTypesFilter);

                    final JComboBox clipCombo = new JComboBox(files);
                    clipCombo.addActionListener( new ActionListener(){
                            // 1.6+
                            Desktop desktop = Desktop.getDesktop();

                            public void actionPerformed(ActionEvent ae) {
                                try {
                                    desktop.open( (File)clipCombo.getSelectedItem() );
                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } );

                    JOptionPane.showMessageDialog(null, clipCombo);
                }
            }
        });
    }
}

class FileTypesFilter implements FilenameFilter {

    private String[] types;

    FileTypesFilter(String[] types ) {
        this.types = types;
    }

    public boolean accept(File dir, String name) {
        for (String type:types) {
            if (name.toLowerCase().endsWith(type.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}