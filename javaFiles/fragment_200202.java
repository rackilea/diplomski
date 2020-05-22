while(rs.next()){
            TranslatedWord word = new TranslatedWord();
            word.setId(rs.getString("id"));
            word.setEnglish(rs.getString("english"));
            word.setBangla(rs.getString("bangla"));
            System.out.println("Row [1] added "+row );
            data.add(row);

        }