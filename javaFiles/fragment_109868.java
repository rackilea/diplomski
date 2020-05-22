#**
 * springFormInput
 *
 * Display a form input field of type 'text' and bind it to an attribute
 * of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *    or CSS styles or size
 *
 *#
#macro( springFormInput $path $attributes )
    #springBind($path)
    <input type="text" id="${status.expression}" name="${status.expression}"
                            value="$!status.value" ${attributes}#springCloseTag()
#end