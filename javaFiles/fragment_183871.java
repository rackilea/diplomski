IntStream.range(0, productReferences.length)
         .filter(index -> productsPrice[index] != null)
         .collect(
            HashMap::new,
            (m, i) -> m.put(productReferences[i], callSomeMethod(productsPrice[i])),
            Map::putAll
         );