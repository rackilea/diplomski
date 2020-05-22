case 0:
            query.append("from Feature f "); 
            if (sf.getTerm() != null && !sf.getTerm().isEmpty()){
                query.append("left join fetch f.actors a left join f.genre g where f.name like :term or a.name like :term or g.name like :term ");
                params.put("term","%"+ sf.getTerm() + "%");
            }
            break;