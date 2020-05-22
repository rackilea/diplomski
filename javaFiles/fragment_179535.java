return lastYearDetails.stream()
        .filter(bdly -> bdly.getId() > 15)
        .flatMap(bdly -> currentYearDetails.stream()
                .filter(bdcy -> !bdcy.getEdition().equals("current"))
                .filter(bdcy -> bdcy.getId() == bdly.getId())
                .map(bdcy -> {
                    Books book = new Books();
                    book.setId(bdly.getId());
                    book.setPrice(Math.max(bdly.getPrice(), bdcy.getPrice()));
                    return book;
                }))
        .collect(Collectors.toList());