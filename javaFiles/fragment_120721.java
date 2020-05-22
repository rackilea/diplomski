import java.io.IOException;

import com.google.gson.*;
import com.google.gson.stream.*;

public class PlanTypeAdapter extends TypeAdapter<Plan> {
    private final String TAG = PlanTypeAdapter.class.getSimpleName();

    @Override
    public void write(JsonWriter out, Plan value) throws IOException {
        Log.d(TAG, "WRITE");
    }

    @Override
    public Plan read(JsonReader reader) throws IOException {
        Log.d(TAG, "READ");
        Plan plan = new Plan();
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        reader.setLenient(false);
        reader.beginObject();

        while (!(reader.peek() == JsonToken.END_OBJECT)) {
            switch (reader.nextName()) {
            case "national_plan":
                handleNationalPlan(reader, plan);
                break;
            case "bill_total":
                handleBillTotal(reader, plan);
                break;
            case "contract_end":
                plan.setContract_end(reader.nextString());
                break;
            case "data_level_gb":
                plan.setData_level_gb(reader.nextString());
                break;
            case "data_level_id":
                plan.setData_level_id(reader.nextInt());
                break;
            case "days_to_end":
                plan.setDays_to_switch(reader.nextInt());
                break;
            case "direct_from_operator":
                plan.setDirect_from_operator(reader.nextBoolean());
                break;
            case "calculation_amount":
                plan.setCalculationAmount(reader.nextDouble());
                break;
            case "network_generation_name":
                plan.setNetwork_generation_(reader.nextString());
                break;
            case "partner_plan_id":
                plan.setPartner_plan_id(reader.nextString());
                break;
            case "payment_level":
                plan.setPayment_level(reader.nextString());
                break;
            case "payment_level_id":
                plan.setPayment_level_id(reader.nextInt());
                break;
            case "roaming_amount":
                plan.setRoaming_amount(reader.nextDouble());
                break;
            case "savings_amount":
                plan.setSavings_amount(reader.nextDouble());
                break;
            case "savings_avg":
                plan.setSavings_avg(reader.nextDouble());
                break;
            case "savings_percents":
                plan.setSavings_percents(reader.nextInt());
                break;
            case "yearly_id":
            case "handset":
            case "internals":
            case "consumer_id":
            case "calculation_details":
            case "operator":
            case "total":
            case "international_plan":
            case "contract_length":
            case "zone":
            case "externals":
            case "cancel_fee":
            case "transformers":
            case "one-offs":
            case "flow":
            case "roaming_plan":
            case "_id":
            // You can use this to ignore the keys you don't care about
            default:
                Log.d(TAG, "DEFAULT " + reader.peek() + "");
                reader.skipValue();
                break;
            }
        }

        reader.endObject();

        return plan;
    }

    private void handleNationalPlan(JsonReader reader, Plan plan) throws IOException {
        reader.beginObject();

        while (!(reader.peek() == JsonToken.END_OBJECT)) {
            switch(reader.nextName()) {
            case "contract_length":
                break;
            case "name":
                break;
            case "country":
            // etc.
            }
        }

        reader.endObject();
    }

    private void handleBillTotal(JsonReader reader, Plan plan) throws IOException {

    }

    // etc.
}