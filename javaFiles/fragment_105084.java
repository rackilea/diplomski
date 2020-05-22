Browser.drive {
  // Load the page
  go "http://myapp.com"

  // $("a") returns all hyperlinks on the page, similar to jQuery
  $("a").each { a ->
     // Display the required link properties and attributes
     println """
        The link to '${a.@href}' with text '${a.text()}' is at location (${a.x}, ${a.y}),
        with a height of ${a.height}px and a width of ${a.width}px.
     """
  }
}