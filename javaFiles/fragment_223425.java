@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)
public class MenuResource {
   ...

   @PATCH
   @Path("/remove/{menuId}/{itemName}")
   public void removeMenuItem(
            @PathParam("menuId") final int menuId,
            @PathParam("itemName") final String itemName) {
      final List<Item> items = this.menuRepository.get(menuId).getItems();

      for (final ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
         final Item item = iterator.next();

         if (itemName.equals(item.getName())) {
            iterator.remove();
            break;
         }
      }
   }

   @PATCH
   @Path("/add/{menuId}")
   public void removeMenuItem(
            @PathParam("menuId") final int menuId,
            final Item item) {  // Item represents the Request Body
      final List<Item> items = this.menuRepository.get(menuId).getItems();
      items.add(item);
   }