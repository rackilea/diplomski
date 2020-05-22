@()

@title = {
<title>Welcome to MessageWorks.</title>
},

@stylesheets = {
<link type="text/css" rel="stylesheet" href="/styles/main.css" />
...
},

@javascripts = {
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
...
},

@page = {
<h1>MessageWorks</h1>
...
} 

@main(title)(stylesheets)(javascripts)(page)