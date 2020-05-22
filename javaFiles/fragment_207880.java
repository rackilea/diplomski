...
query.from(product).where(predicate);    
if(isColorFilterSet()) {    
    JPAQuery colorQuery = query.from(color).innerJoin(product.colors, color)
                  .groupBy(color);
    List<Color> colors = colorQuery.list(color);
    filter.setFilterableBaseColors(colors);
}