/* Dropdown Button */
.dropbtn {
    background-color: rgba(102, 146, 255, 0.87);
    color: white;
    padding: 9px 15px 14px 15px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    border-radius: 6px;

vertical-align: bottom;font-size: 24px; /*HERE The CODE of SPAN*/

}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
    background-color: #6692FF;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 9px 32px;
    text-decoration: none;
    display: block !important;
    border-bottom: 1px solid #4A5056;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f9f9f9}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}