.transform(Message.class, m -> {
                Facts facts = (Facts) m.getPayload();
                int num = (int) m.getHeaders().get("NUM");
                return facts.getAll().get(num);
            })
            .headerFilter(MessageHeaders.CONTENT_TYPE)
            .transform(CatFact.class, id -> id)