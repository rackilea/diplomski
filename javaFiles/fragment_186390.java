<ul >
    <li ${view eq "tab1"?'class="active"':''}>
        <a href="#tab_0" id="tab1" data-toggle="tab">Search by Booking ID</a>
    </li>
    <li ${view eq "tab2"?'class="active"':''}>
        <a href="#tab_1" id="tab2" data-toggle="tab">Today's Booking</a>
    </li>
    <li ${view eq "tab3"?'class="active"':''}>
        <a href="#tab_2" id="tab3" data-toggle="tab">Search by Date</a>
    </li>
</ul>