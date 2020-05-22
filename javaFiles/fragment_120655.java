.tab-content {
 background-color: #e5e5e5;
 color: #666;
 min-height: 150px;
 overflow: auto; 
}

.tab-links{
 float:left;
}
.tab-links:after {
 display:block;
 clear:both;
 content:'';
}

.tab-links li {
 list-style-type: none;
 background-color: #303030;
 
 text-transform: uppercase;
 letter-spacing: 0.09em;
 margin-left: -25%;
 
}
.tab-links li a {
 color: #f2f2f2;
 display: block;
 
 text-decoration: none;
}
 
.tab-links a:hover {
 background:#a7cce5;
 text-decoration:none;
}

.tab-links li.active, .tab-links li.hover {
 background-color: #e5e5e5;
 
}

.tab-links li.active a, .tab-links li a:hover {
 color: #666;
 
}

#tab1 {padding-left: 30%;}
#tab2, #tab3, #tab4 { 
  display:none; 
  opacity: 0;
  padding-left: 0%;
}

.tab-content p { 
 margin: 20px;
 text-indent: -40%;
}
 
.tab-content.active{
 display: block;
 text-indent: none;
}