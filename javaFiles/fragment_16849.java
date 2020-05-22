@JsonAppend(prepend=true, 
                props = {
                    @JsonAppend.Prop(name="productId", value=VirtualBeanProductIdPropertyWriter.class, include=Include.ALWAYS, required=true)
                }
            )
...