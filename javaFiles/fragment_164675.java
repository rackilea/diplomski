@import java.text.SimpleDateFormat
@(date: java.util.Date)

<html>
    @defining(new SimpleDateFormat("yyyy-MM-dd")) { dateFormatter =>
        <body>
            <div>
                <b>Raw: </b>@date
            </div>
            <div>
                <b>In-line formatter: </b>@(new SimpleDateFormat("yyyy-MM-dd").format(date))
            </div>
            <div>
                <b>Shared formatter: </b>@dateFormatter.format(date)
            </div>
        </body>
    }
</html>