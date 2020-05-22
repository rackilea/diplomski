try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = formatter.parse(requestModel.getSelectedDate());
        } catch (ParseException e) {
            e.printStackTrace();
            bindingResult.rejectValue("selectedDate", "Invalid Date");
            return "request";
        }