import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FooServiceIT {

    @Test
    @Order(1)
    public void testUploadSuccess() {
        System.out.println("1");
    }

    @Test
    @Order(2)
    public void testDownloadSuccess() {
        System.out.println("2");
    }

    @Test
    @Order(3)
    public void testDeleteSuccess() {
        System.out.println("3");
    }
}