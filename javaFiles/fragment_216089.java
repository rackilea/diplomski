@(field: play.api.data.Field, options: Seq[(String,String)], args: (Symbol,Any)*)(implicit handler: FieldConstructor, lang: play.api.i18n.Lang)
@input(field, args:_*) { (id, name, value, htmlArgs) =>
  <select multiple="multiple" id="@id" name="@{name}[]" size="@{5 min options.length}">
    @for(i <- 0 until options.length) {
        <option id="@id" value="@options(i)._1"  
            @(if(field.indexes.exists(index => field("["+index+"]").value == Some(options(i)._1) ) ) "selected" else "")
        @toHtmlArgs(htmlArgs) >@options(i)._2</option>      
      }
  </select>
}