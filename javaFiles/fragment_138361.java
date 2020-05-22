list1.forEach(element ->
                list2.stream()
                     .filter(item -> element.getKey().equals(item.getKeyNextYear()))
                     .findAny()
                     .ifPresent(item -> {
                         element.setSummPreviosYear(item.getSumm());
                         element.setCashboxCountPreviosYear(item.getCashboxCount());
                         element.setCheckCountPreviosYear(item.getCheckCount());
                         element.setArticleCountPreviosYear(item.getArticleCount());
                     }));