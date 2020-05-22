for (String field : fields)
        {
            if (field.contains(" " + pk))
            {
                callIdField = field;
                break;
            }
        }