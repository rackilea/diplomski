int firstSpace = line.indexOf(' ');
String command = line;
if (firstSpace > 0)
    command = line.substring(0, firstSpace);
Directive directive = directives.get(command.toUpperCase());
if (directive != null)
    directive.execute(line);
else
    ...show some error...