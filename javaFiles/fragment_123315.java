@RequestMapping(value = "/large.csv", method = GET, produces = "text/csv")
@ResponseStatus(value = HttpStatus.OK)
public void streamLargeCSV(OutputStream out) {
    // Make an HTTP Request to http://application1/getbigcsv
    // Return its response
}