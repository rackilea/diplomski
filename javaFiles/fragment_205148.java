public String getSpecificProduct(int position) {
    if (array_produtos.isEmpty() || array_produtos.size()<position+1) {
        return "";
    }else{
    return array_produtos.get(position).getNome();
    }
 }