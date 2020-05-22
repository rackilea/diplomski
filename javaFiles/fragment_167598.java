/**
                 * Leer registros en la tabla
                 * @throws NamingException 
                 * @throws IOException 
                **/ 

                private void select() throws NamingException {  

                    //System.out.println("entre al metodo SELECT");     
                // ESTE SELECT SE ENCARGAR DE LLENAR EL ARREGLO VLTABLA PARA LA ETIQUETA FOREACH //     

                //Consulta paginada             
                String query = "SELECT A.CODIGO, A.DESCR ";
                    query += " FROM PRUEBA1 A";
                    query += " GROUP BY A.CODIGO, A.DESCR";
                    query += " ORDER BY  1";
                //System.out.println(query);

                consulta.selectPntGenerica(query, JNDI);    
                inputnumber = consulta.getRows();
                if(inputnumber>0){
                vltabla = consulta.getArray();

                  } 
               }