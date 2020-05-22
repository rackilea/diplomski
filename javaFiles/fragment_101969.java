@Test
public class ExampleDataProvider {

   /**
     * Returns the list of shape codes.
     * 
     * @return the collection shape codes.
     */
    @DataProvider(name = "ShapeCodes")
    public static Object[][] getShapeCodes() {
        return new Object[][] { new Object[] { Shape.Square }, 
            new Object[] { Shape.Triangle }
        };
    }

    /**
     * Returns the list of color codes.
     * 
     * @return the collection of color codes.
     */
    @DataProvider(name = "ColorCodes")
    public static Object[][] geColorCodes() {
        return new Object[][] { new Object[] { Color.Green }, 
            new Object[] { Color.Red }
        };
    }

    /**
     * Returns the list object codes providing a color shape combination.
     * 
     * @return the collection of object codes.
     */
    @DataProvider(name = "objectCodes")
    public static Object[][] getObjectCodes(){
        return combine(geColorCodes(),  getShapeCodes());
    }


    /**
     * Returns the list of combination of color and shape codes.
     * 
     * @return the collection of combined color and shape codes.
     */
    public static Object[][] combine(Object[][] a1, Object[][] a2){
        List<Object[]> objectCodesList = new LinkedList<Object[]>();
        for(Object[] o : a1){
            for(Object[] o2 : a2){
                objectCodesList.add(concatAll(o, o2));
            }
        }
         return objectCodesList.toArray(new Object[0][0]);
    }


    @SafeVarargs
    public static <T> T[] concatAll(T[] first, T[]... rest) {
     //calculate the total length of the final object array after the concat    
      int totalLength = first.length;
      for (T[] array : rest) {
        totalLength += array.length;
      }
      //copy the first array to result array and then copy each array completely to result
      T[] result = Arrays.copyOf(first, totalLength);
      int offset = first.length;
      for (T[] array : rest) {
        System.arraycopy(array, 0, result, offset, array.length);
        offset += array.length;
      }

      return result;
    }
}