package sandbox;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class GetFileHandle {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("somedata.txt")) {
            FileDescriptor fd = fis.getFD();

            Field field = fd.getClass().getDeclaredField("fd");
            field.setAccessible(true);
            Object fdId = field.get(fd);
            field.setAccessible(false);

            field = fd.getClass().getDeclaredField("handle");
            field.setAccessible(true);
            Object handle = field.get(fd);
            field.setAccessible(false);

            // One of these will be -1 (depends on OS)
            // Windows uses handle, non-windows uses fd
            System.out.println("fid.handle="+handle+"  fid.fd"+fdId);
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}