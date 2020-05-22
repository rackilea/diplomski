Document doc = new Document();

        doc.add(new TextField("contents", "Homer January, Lenny February",Store.YES));
        doc.add(new TextField("title", "2017 on call schedule.xls", Store.YES));

        iwriter.addDocument(doc);

        doc = new Document();
        doc.add(new TextField("contents", "Carl January, Frank February",Store.YES));
        doc.add(new TextField("title", "2018 on call schedule.xls", Store.YES));

        iwriter.addDocument(doc);

        iwriter.commit();