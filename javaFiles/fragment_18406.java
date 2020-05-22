import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatalogTest
{

    /**
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub

        String name = null;
        String code = null;
        double price = 0.0;
        String phrase = null;

        BufferedReader input = new BufferedReader(new InputStreamReader(
            System.in));

        Catalog product = new Catalog(name, code, price, phrase);

        Catalog[] productsArray = new Catalog[100];

        for (int i = 0; i < productsArray.length; i++)
        {

            System.out.println("Enter product description (or # to stop): ");
            name = input.readLine();

            if (!("#".equals(name)))
            {

                productsArray[i] = product;
                product.setDescription(name);

                System.out.println("Enter product code: ");
                code = input.readLine();
                productsArray[i] = product;
                product.setCode(code);

                System.out.println("Enter product unit price: ");
                price = Double.parseDouble(input.readLine());
                productsArray[i] = product;
                product.setPrice(price);

                System.out.println("Enter product unit phrase: ");
                phrase = input.readLine();
                productsArray[i] = product;
                product.setPhrase(phrase);

                productsArray[i] = new Catalog(name, code, price, phrase);

            }

            else
            {
                System.out.println("Your Catalog:");
                for (int j = 0; j < productsArray.length; j++)
                {
                    if(productsArray[j]!=null)
                    {
                        System.out.printf("%s, %s,$%.2f %s,",
                            productsArray[j].getCode(),
                            productsArray[j].getDescription(),
                            productsArray[j].getPrice(),
                            productsArray[j].getPhrase());
                    }
                }
                break;
            }

        }

    }
}