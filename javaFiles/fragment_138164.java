private List<Categoria> getAlberoCategorie(Categoria root, int profondita) {
        List<Categoria> tmpList = new ArrayList<Categoria>();
        root.setProfondita(profondita);
        if ( root.getParent() != null ) {
            Hibernate.initialize(root.getTraduzioni());
            tmpList.add(root);
        }       

        List<Categoria> children = root.getChildren();
        Collections.sort(children, new Comparator<Categoria>() {
            @Override
            public int compare(Categoria o1, Categoria o2) {
                return o1.getOrdinamento().compareTo(o2.getOrdinamento());
            }
        });

        if (!children.isEmpty()) {
            profondita++;
            for (Categoria figlia : children) {
                List<Categoria> discendenza = getAlberoCategorie(figlia,profondita);                
                tmpList.addAll(discendenza);
            }
        }       
        return tmpList;
    }