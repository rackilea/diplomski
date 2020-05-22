@(item: Item)
<ul>
  @for(field <- item.getClass().getDeclaredFields()) {
    <li>@field.getName() = @field.get(item)</li>
  } 
</ul>