@ManyToOne
@JoinColumnsOrFormulas(
    { @JoinColumnOrFormula(
        formula = @JoinFormula(
         value = "case " +
                 "when type == 'B' then book_id" +
                 "when type == 'S' then series_id " +
                 "else 1" +
                 "end", 
         referencedColumnName="book_id")) }
)