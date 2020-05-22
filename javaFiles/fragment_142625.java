Checkbox checkbox = new Checkbox
        {
            TabLabel = "ToggleNumber3",
            Selected = "True",
            XPosition = "10",
            YPosition = "10",
            DocumentId = "1",
            PageNumber = "1",
        };

        Number number1 = new DocuSign.eSign.Model.Number
        {
            TabLabel = "Number1",
            Value = "1",
            RecipientId = "1",
            XPosition = "20",
            YPosition = "10",
            DocumentId = "1",
            PageNumber = "1",
        };

        Number number2 = new Number
        {
            TabLabel = "Number2",
            Value = "2",
            XPosition = "30",
            YPosition = "10",
            DocumentId = "1",
            PageNumber = "1",
        };

        Number number3 = new Number
        {

            TabLabel = "Number3",
            Value = "8",
            XPosition = "500",
            YPosition = "10",
            ConditionalParentLabel = "ToggleNumber3",
            ConditionalParentValue = "On",
            DocumentId = "1",
            PageNumber = "1",
        };

        FormulaTab additionFormula = new FormulaTab
        {
            TabLabel = "AdditionFormula",
            YPosition = "30",
            XPosition = "10",
            Formula = "[Number1] + [Number2] + [Number3]",
            DocumentId = "1",
            PageNumber = "1",
        };



        // Add the sign here tab array to the signer object.
        signer.Tabs = new Tabs
        {
            SignHereTabs = new List<SignHere>(signHereTabs),
            NumberTabs = new List<Number> { number1, number2, number3},
            FormulaTabs = new List<FormulaTab> { additionFormula },
            CheckboxTabs = new List<Checkbox> { checkbox },

        };