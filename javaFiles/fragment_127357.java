package restapp.examples;
import java.util.ArrayList;
import java.util.List;
import com.softlayer.api.*;
import com.softlayer.api.service.Hardware;
import com.softlayer.api.service.hardware.Server;
import com.softlayer.api.service.Location;
import com.softlayer.api.service.network.Component;
import com.softlayer.api.service.product.Order;
import com.softlayer.api.service.product.item.Price;
import com.softlayer.api.service.product.pkg.Preset;
import com.google.gson.Gson;

public class OrderPreSetBMS2
{
  public static void main( String[] args )
  {
    String user = "set me";
    String apiKey = "set me";

    Location datacenter = new Location();
    datacenter.setName("ams01");

    Preset preset = new Preset();
    preset.setKeyName("S1270_8GB_2X1TBSATA_NORAID");

    Component networkComponent = new Component();
    networkComponent.setMaxSpeed(100L);


    Hardware hardware = new Hardware();
    hardware.setDatacenter(datacenter);
    hardware.setHostname("simplebmi");
    hardware.setDomain("test.com");
    hardware.setHourlyBillingFlag(true);
    hardware.setFixedConfigurationPreset(preset);
    List<Component> networkComponents = hardware.getNetworkComponents();
    networkComponents.add(networkComponent);
    hardware.setOperatingSystemReferenceCode("UBUNTU_14_64");

    ApiClient client = new RestApiClient().withCredentials(user, apiKey).withLoggingEnabled();
    Hardware.Service hardwareService = Hardware.service(client); 
    Order.Service orderService = Order.service(client); 

    try
    {
      com.softlayer.api.service.container.product.Order productOrder = hardwareService.generateOrderTemplate(hardware);
      Gson gson = new Gson();
      System.out.println(gson.toJson(productOrder));
      com.softlayer.api.service.container.product.Order order = orderService.verifyOrder(productOrder);
      Gson gson2 = new Gson();
      System.out.println(gson2.toJson(order));
    }
    catch(Exception e)
    {
        System.out.println("Error: " + e);  
    }
  }
}