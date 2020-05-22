refMesaVirtual.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    listaPedido = new ArrayList<Pedido>();
    Pedido p = dataSnapshot.getValue(Pedido.class); //!!
    listaPedido.add(p);
    adaptadorListarPedidos = new AdaptadorListarPedidos(ArticulosSeleccionadosActivity.this, listaPedido/*, nombre, precio*/);
    recyclerViewPedidos.setAdapter(adaptadorListarPedidos);
    recyclerViewPedidos.setHasFixedSize(true);
        }
@Override
public void onCancelled(@NonNull DatabaseError databaseError) {
      Toast.makeText(ArticulosSeleccionadosActivity.this, "Upss.. Algo anda mal!", Toast.LENGTH_SHORT).show();
        }
    });