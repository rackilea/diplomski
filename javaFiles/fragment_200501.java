<html>
    <head>
        <title>{% block title %}Jangod ????{% endblock %}</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div id="content">
            {% block content %}{% endblock %}
        </div>
        <div id="footer">
            {% block footer %}
            © Copyright 2010
            {% endblock %}
        </div>
    </body>
</html>