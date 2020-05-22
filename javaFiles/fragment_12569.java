client.open("GET", reportUrl, true);
client.onreadystatechange = responseListener;
client.send();

var reportContents = document.getElementById("reportContents");
// Since this could considerably slow browsers for large reports,
// don't edit report contents for every readystate equal to 3.
// Do it every 10.
var batchUpdate = 10;
var responsesSinceUpdate = 0;
// Don't update the whole contents, just add the new stuff
// since the last update.
var currentLengthOfReportHtml = 0;
// Have max recommended length of report before showing warning.
var maxRecommendedReportLength = 500000;

function responseListener()
{
    if (this.status == 200)
    {
        var readyState = this.readyState;

        if (readyState == 3 || readyState == 4)
        {
            var updatePage = false;

            if (readyState == 4)
            {
                updatePage = true;
                var loadingDiv = document.getElementById("reportLoading");
                loadingDiv.innerHTML = "";
                toggleLargeReportWarning(false);
            }
            else
            {
                responsesSinceUpdate++;

                if (responsesSinceUpdate > batchUpdate)
                {
                    updatePage = true;
                    responsesSinceUpdate = 0;
                }
            }

            if (updatePage)
            {
                var reportLength = this.responseText.length;
                reportContents.innerHTML += this.responseText.substring(currentLengthOfReportHtml);
                currentLengthOfReportHtml = reportLength;

                if (reportLength > maxRecommendedReportLength && readyState == 3)
                {
                    toggleLargeReportWarning(true);
                }
            }
        }
    }
}