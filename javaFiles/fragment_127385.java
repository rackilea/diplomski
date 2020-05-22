List<Produto> toAdd = new ArrayList<>();
for(Produto produto : arProduct) {
   // ...
   toAdd.add(new Produto(nomeProduto, precoProduto, mensagemAdicional, letraPrateleira, nrPosicao));
}
produto.addAll(toAdd);