// To create your map:
Map<Integer, List<Ordine>> listaordini = new HashMap<Integer, List<Ordine>>( );



// To add an order to it:
Ordine ord = new Ordine(Integer.parseInt(cod_pizza),Integer.parseInt(n_pizze));

List<Ordine> ordineList = cl.getListaOrdini( ).get(Integer.parseInt(cod_ordine));
if (ordineList == null)
{
    ordineList = new ArrayList<Ordine>( );
    cl.getListaOrdini( ).put(Integer.parseInt(cod_ordine), ordineList);
}

ordineList.add(ord);