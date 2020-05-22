object HelloJavaFXTest: Spek({
    given("the JavaFX Toolkit") {
        // Initialise JavaFX Toolkit, needed for things like ProgressIndicator.
        FxToolkit.registerPrimaryStage()
        FxToolkit.setupApplication(HelloJavaFX::class.java)

        on("instantiating a JavaFX component") {
            val progress = ProgressIndicator()
            it("should not throw any errors") {
                progress.isVisible = false
            }
        }

    }
})