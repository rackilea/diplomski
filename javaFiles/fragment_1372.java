<html>
    <body>
        {% if v instanceof "com.mypackage.test.Entity" %}
            <b>{{ v.asd }}</b>
        {% endif %}
        {% if v instanceof "com.mypackage.test.Fruit" %}
            <b>{{ v.color }}</b>
        {% endif %}
    </body>
</html>