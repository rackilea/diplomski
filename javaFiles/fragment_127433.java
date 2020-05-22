app.post("/rapportini/generarapportino", async function (request, response) {

    try {
        const ret = await RapportiniController.GeneraRapportino(request.body.Note);
        response.json({
            return: ret
        });
    } catch (err) {
        console.log("Error ", err)
    }
});