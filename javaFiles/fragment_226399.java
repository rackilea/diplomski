import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileDemo implements Serializable {
    static class FileList implements Serializable {
        List<FileData> list = new ArrayList<>();
    }

    static class FileData implements Serializable { }

    public static void main(String[] args) throws IOException {
        File file = new File("log.data");
        FileList list = new FileList();
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (FileList) ois.readObject();
            }
        }
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("MENU\n" +
                    "Enter 1 to add new object to file\n" +
                    "Enter 2 to display list size\n" +
                    "Enter 3 to exit\n" +
                    "Enter your choice: ");
            int option = scn.nextInt();
            switch (option) {
                case 1:
                    list.list.add(new FileData());
                    File tmp = new File("log.data.tmp");
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmp))) {
                        oos.writeObject(list);
                    }
                    Files.move(tmp.toPath(), file.toPath(), REPLACE_EXISTING);
                    System.out.println("Object Added");
                    break;
                case 2:
                    System.out.println(list.list.size());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}