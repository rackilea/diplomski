Vector<SoapObject> vector = (Vector<SoapObject>) envelope.getResponse();


           Log.d("Response in SOAP",vector.toString());

            for (int i=0; i< vector.size();i++){
                SoapObject object = (SoapObject) vector.get(i);

               if (object!=null){
                  Log.d("Vencimento", object.getProperty(0).toString());
                   Log.d("ValorAtualizado", object.getProperty(1).toString());
                   Log.d("Valor", object.getProperty(2).toString());
                   Log.d("Sequencia", object.getProperty(3).toString());
                   Log.d("NroBanco", object.getProperty(4).toString());
                   Log.d("BcoCobr", object.getProperty(5).toString());
                   Log.d("Cobranca", object.getProperty(6).toString());

                   Vector<Object> itens= (Vector<Object>) object.getProperty(7);

                   for (int j=0; j<itens.size();j++){
                         SoapObject item =(SoapObject) itens.get(j);
                       Log.d("Descricao", item.getProperty("Descricao").toString());
                       Log.d("ValorItem", item.getProperty("ValorItem").toString());

                   }



                }

            }