package q9318686;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class secim_ekle extends JFrame {

    private JButton ekle;
    private JLabel dizi_isim;
    private JLabel dizi_puan;
    private JLabel kaydet;
    private JTextField dizi_isim_fd;
    private JTextField dizi_puan_fd;
    File dosya = new File("dizi_listesi.txt");

    public secim_ekle() throws IOException {

        super("Ekleme işlemi");
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        this.setSize(500, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 300);

        final BufferedWriter yazici = 
                new BufferedWriter(new FileWriter(dosya, true));
        final BufferedReader okuyucu = 
                new BufferedReader(new FileReader(dosya));

// The following line overrides your file:        
//        final Formatter yaz = new Formatter(dosya);
        final Scanner oku = new Scanner(dosya);

        ekle = new JButton("Ekle");
        this.getContentPane().add(ekle);

        dizi_isim = new JLabel("Dizi ismi :");
        this.getContentPane().add(dizi_isim);

        dizi_puan = new JLabel("Dizi puan :");
        this.getContentPane().add(dizi_puan);

        kaydet = new JLabel("Veriler Kaydedildi!");
        kaydet.setVisible(false);
        kaydet.setForeground(Color.RED);
        this.getContentPane().add(kaydet);

        dizi_isim_fd = new JTextField();
        this.getContentPane().add(dizi_isim_fd);

        dizi_puan_fd = new JTextField();
        this.getContentPane().add(dizi_puan_fd);

        dizi_isim.setBounds(10, 10, 100, 20);
        dizi_puan.setBounds(10, 40, 100, 20);
        dizi_isim_fd.setBounds(120, 10, 200, 20);
        dizi_puan_fd.setBounds(120, 40, 50, 20);
        ekle.setBounds(350, 10, 100, 20);
        kaydet.setBounds(350, 40, 200, 40);

        ekle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == ekle) {
                    try {
                        yazici.write(dizi_isim_fd.getText() + "|" 
                                + dizi_puan_fd.getText());
                        yazici.newLine();
                        yazici.close();
                        kaydet.setVisible(true);
                    } catch (Exception h) {
                        System.out.print(h.getMessage());
                    }
                }

            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new secim_ekle().setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}