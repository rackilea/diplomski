{% extends "base.html" %}
{% block title %}Hello {{user.name}}{% endblock %}
{% block content %}
    <h1>Recencies</h1>
    <ul>
        {% for post in posts %}
            <li>{{post.title}}</li>
        {% endfor %}
    </ul>
{% endblock %}