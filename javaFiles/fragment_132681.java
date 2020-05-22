import java.sql.Timestamp;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.netezza.ae.Nzae;
import org.netezza.ae.NzaeApi;
import org.netezza.ae.NzaeApiGenerator;
import org.netezza.ae.NzaeDataTypes;
import org.netezza.ae.NzaeException;
import org.netezza.ae.NzaeMetadata;
import org.netezza.ae.NzaeRecord;
import org.netezza.ae.NzaeUtil;

public class viewResolver {
private static final Executor exec = Executors.newCachedThreadPool();

public static final void main(String[] args) {
    try {
        mainImpl(args);
    } catch (Throwable t) {
        System.err.println(t.toString());
        NzaeUtil.logException(t, "main");
    }

}

public static final void mainImpl(String[] args) {
    NzaeApiGenerator helper = new NzaeApiGenerator();
    while (true) {
        final NzaeApi api = helper.getApi(NzaeApi.FUNCTION);
        if (api.apiType == NzaeApi.FUNCTION) {
            if (!helper.isRemote()) {
                run(api.aeFunction);
                break;
            } else {
                Runnable task = new Runnable() {
                    public void run() {
                        try {
                            viewResolver.run(api.aeFunction);
                        } finally {
                            api.aeFunction.close();
                        }
                    }
                };
                exec.execute(task);
            }
        }
    }
    helper.close();
}

public static int run(Nzae ae) {
    try {
        int ret = runReal(ae);
        ae.done();
        return ret;
    } catch (NzaeException ex) {
        ex.printStackTrace();
        ae.userError(ex.getMessage());
        ae.done();
        throw ex;
    } catch (Throwable ex) {
        ex.printStackTrace();
        ae.userError(ex.toString());
        ae.done();
        throw new NzaeException(ex.toString());
    }
}

static String acc_id = null;
static String rec_id = null;
static String tuner = null;
static String channel = null;
static String show_name = null;
static String tmsId = null;
static String viewing_type = null;
static String event_type = null;
static String channelFamily = null;
static String ruid = null;
static int suid = 0;
static double timeStarted = 0;
static double timeEnded = 0;
static Timestamp datecreated = null;
static double content_start = 0;
static double content_end = 0;

static String prev_acc_id = null;
static String prev_rec_id = null;
static String prev_tuner = null;
static String prev_channel = null;
static String prev_show_name = null;
static String prev_tmsId = null;
static String prev_viewing_type = null;
static String prev_event_type = null;
static String prev_channelFamily = null;
static String prev_ruid = null;
static int prev_suid = 0;
static double prev_timeStarted = 0;
static double prev_timeEnded = 0;
static Timestamp prev_datecreated = null;
static double prev_content_start = 0;
static double prev_content_end = 0;

public static int runReal(Nzae ae) {

    double dvr_time_watched = 0;
    double vod_time_watched = 0;
    double manual_ffx = 0;
    double manual_ffr = 0;
    boolean end = false;
    double tune_duration = 0;
    boolean live_DVR_Flag = false;
    final NzaeMetadata meta = ae.getMetadata();
    NzaeRecord input = null;
    boolean firstRecord = true;

    validateInput(meta);
    while (!end) {
        NzaeRecord output = ae.createOutputRecord();
        if (true) {
            input = ae.next();

            if (input == null) {// checks if no more records
                end = true;
                // returns the final view
                if (prev_timeEnded - prev_timeStarted != 0) {// if final view is tune
                    tune_duration = prev_timeEnded - prev_timeStarted;
                    output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel, prev_show_name,
                            prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily, prev_ruid,
                            prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated, 0, 0, tune_duration,
                            manual_ffx, manual_ffr);
                    ae.outputResult(output);

                }
                if (vod_time_watched != 0 || dvr_time_watched != 0 || manual_ffr != 0 || manual_ffx != 0) {

                    if (!prev_event_type.equalsIgnoreCase("DVR_EOE") && dvr_time_watched != 0) {// if DVR
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, dvr_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    } else if (!prev_event_type.equalsIgnoreCase("DVR_EOE") && vod_time_watched != 0) {// if VOD
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, vod_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    }

                }
                continue;
            } else {// set variables
                if (input.getField(0) != null)
                    acc_id = input.getField(0).toString();
                else
                    acc_id = null;
                if (input.getField(1) != null)
                    rec_id = input.getField(1).toString();
                else
                    rec_id = null;
                if (input.getField(2) != null)
                    tuner = input.getField(2).toString();
                else
                    tuner = null;
                if (input.getField(3) != null)
                    channel = input.getField(3).toString();
                else
                    channel = null;
                if (input.getField(4) != null)
                    show_name = input.getField(4).toString();
                else
                    show_name = null;
                if (input.getField(5) != null)
                    tmsId = input.getField(5).toString();
                else
                    tmsId = null;
                if (input.getField(6) != null)
                    viewing_type = input.getField(6).toString();
                else
                    viewing_type = null;
                if (input.getField(7) != null)
                    event_type = input.getField(7).toString();
                else
                    event_type = null;
                if (input.getField(8) != null)
                    channelFamily = input.getField(8).toString();
                else
                    channelFamily = null;
                if (input.getField(9) != null)
                    ruid = input.getField(9).toString();
                else
                    ruid = null;
                if (input.getField(10) != null)
                    suid = input.getFieldAsNumber(10).intValue();
                else
                    suid = 0;
                if (input.getField(11) != null)
                    timeStarted = input.getFieldAsNumber(11).doubleValue();
                else
                    timeStarted = 0;
                if (input.getField(12) != null)
                    timeEnded = input.getFieldAsNumber(12).doubleValue();
                else
                    timeEnded = 0;
                if (input.getField(13) != null)
                    datecreated = input.getFieldAsTimestamp(13);
                else
                    datecreated = null;
                if (input.getField(14) != null)
                    content_start = input.getFieldAsNumber(14).doubleValue();
                else
                    content_start = 0;
                if (input.getField(15) != null)
                    content_end = input.getFieldAsNumber(15).doubleValue();
                else
                    content_end = 0;

            }
        }

        if (firstRecord) {

            prev_acc_id = acc_id;
            prev_rec_id = rec_id;
            prev_tuner = tuner;
            prev_channel = channel;
            prev_show_name = show_name;
            prev_tmsId = tmsId;
            prev_viewing_type = viewing_type;
            prev_event_type = event_type;
            prev_channelFamily = channelFamily;
            prev_ruid = ruid;
            prev_suid = suid;
            prev_timeStarted = timeStarted;
            prev_timeEnded = timeEnded;
            prev_datecreated = datecreated;
            prev_content_start = content_start;
            prev_content_end = content_end;

            firstRecord = false;
        }

        // ********* if acc id or rec id changes
        if (prev_acc_id != null && prev_rec_id != null && prev_acc_id != null && prev_rec_id != null) {
            if (!prev_acc_id.equalsIgnoreCase(acc_id) || !prev_rec_id.equalsIgnoreCase(rec_id)) {
                if (prev_timeEnded - prev_timeStarted != 0) {// if tune
                    tune_duration = prev_timeEnded - prev_timeStarted;
                    output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel, prev_show_name,
                            prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily, prev_ruid,
                            prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated, 0, 0, tune_duration,
                            manual_ffx, manual_ffr);
                    ae.outputResult(output);
                    prev_timeEnded = prev_timeStarted = 0;

                    setPreviousValues();
                    tune_duration = 0;
                    manual_ffr = 0;
                    manual_ffx = 0;

                }
                if (dvr_time_watched != 0 || manual_ffr != 0 || manual_ffx != 0) {

                    if (!prev_event_type.equalsIgnoreCase("DVR_EOE")) {// if DVR
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, dvr_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    }
                    dvr_time_watched = 0;
                    manual_ffr = 0;
                    manual_ffx = 0;
                    setPreviousValues();
                    live_DVR_Flag = false;

                }
                if (vod_time_watched != 0 || manual_ffr != 0 || manual_ffx != 0) {

                    if (!prev_event_type.equalsIgnoreCase("DVR_EOE")) {// if VOD
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, vod_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    }
                    vod_time_watched = 0;
                    manual_ffr = 0;
                    manual_ffx = 0;
                    setPreviousValues();
                    live_DVR_Flag = false;

                }

            }
        }

        // ******** special case tune to DVR
        if (viewing_type != null && prev_viewing_type != null)
            if ((live_DVR_Flag || prev_viewing_type.equalsIgnoreCase("Tune"))
                    && viewing_type.equalsIgnoreCase("DvrEvent")) {

                if (tmsId != null)
                    if (!prev_tmsId.equalsIgnoreCase(tmsId)) {
                        if (live_DVR_Flag) {
                            // should change the event name to "Live DVR"
                            if (!prev_event_type.equalsIgnoreCase("DVR_EOE")) {
                                output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                        prev_show_name, prev_tmsId, "LiveDVR", prev_event_type, prev_channelFamily,
                                        prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                        prev_content_start, prev_content_end, dvr_time_watched, manual_ffx,
                                        manual_ffr);
                                ae.outputResult(output);
                            }

                            dvr_time_watched = 0;
                            manual_ffr = 0;
                            manual_ffx = 0;
                            setPreviousValues();
                            live_DVR_Flag = false;

                        }
                    }
                if (tmsId != null)
                    if (prev_tmsId.equalsIgnoreCase(tmsId))
                        if (event_type != null && content_start != 0 && content_end != 0) {
                            live_DVR_Flag = true;
                            // ******* total play time
                            if (event_type.equalsIgnoreCase("DVR_PLAY") || event_type.equalsIgnoreCase("DVR_PAUSE")) {
                                dvr_time_watched += (content_end - content_start);
                            }
                            // ********* total ffx time
                            if (event_type.contains("FWD_START") && !event_type.contains("SKIP")) {
                                manual_ffx += (content_end - content_start);
                            }
                            // ********** total ffr time
                            if (event_type.contains("FWD_END") && !event_type.contains("SKIP")) {
                                manual_ffr += (content_end - content_start);
                            }
                        }

            }

        // ******** special case DVR to tune
        if (viewing_type != null && prev_viewing_type != null)
            if ((live_DVR_Flag || prev_viewing_type.equalsIgnoreCase("DvrEvent"))
                    && viewing_type.equalsIgnoreCase("Tune")) {

                if (tmsId != null)
                    if (!prev_tmsId.equalsIgnoreCase(tmsId)) {
                        if (live_DVR_Flag) {
                            tune_duration = prev_timeEnded - prev_timeStarted;
                            output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                    prev_show_name, prev_tmsId, "LiveDVR", prev_event_type, prev_channelFamily,
                                    prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated, 0, 0,
                                    tune_duration, manual_ffx, manual_ffr);
                            ae.outputResult(output);
                            prev_timeEnded = prev_timeStarted = 0;

                            setPreviousValues();
                            tune_duration = 0;
                            manual_ffr = 0;
                            manual_ffx = 0;
                            live_DVR_Flag = false;

                        }
                    }
                if (tmsId != null)
                    if (prev_tmsId.equalsIgnoreCase(tmsId))
                        if (timeEnded != 0)
                            prev_timeEnded = timeEnded;
            }

        // ***** For Tune events
        if (prev_viewing_type.equalsIgnoreCase("Tune")) {

            if (tmsId != null)
                if (!prev_tmsId.equalsIgnoreCase(tmsId)) {
                    if (prev_timeEnded != 0) {
                        tune_duration = prev_timeEnded - prev_timeStarted;
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated, 0, 0,
                                tune_duration, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                        prev_timeEnded = prev_timeStarted = 0;
                        setPreviousValues();
                        tune_duration = 0;
                        manual_ffr = 0;
                        manual_ffx = 0;

                    }
                }
            if (timeEnded != 0)
                prev_timeEnded = timeEnded;
        }
        // ************ for DVR events
        else if (prev_viewing_type.contains("DvrEvent")) {

            if (tmsId != null)
                if (!prev_tmsId.equalsIgnoreCase(tmsId)) {
                    if (!prev_event_type.equalsIgnoreCase("DVR_EOE")) {
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, dvr_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    }
                    dvr_time_watched = 0;
                    manual_ffr = 0;
                    manual_ffx = 0;
                    setPreviousValues();

                }
            if (event_type != null && content_start != 0 && content_end != 0) {
                // ******* total play time
                if (event_type.equalsIgnoreCase("DVR_PLAY") || event_type.equalsIgnoreCase("DVR_PAUSE")) {
                    dvr_time_watched += (content_end - content_start);
                    // play_end = row.getCONTENT_END_EPOCH();
                }
                // ********* total ffx time
                if (event_type.contains("FWD_START") && !event_type.contains("SKIP")) {
                    manual_ffx += (content_end - content_start);
                }
                // ********** total ffr time
                if (event_type.contains("FWD_END") && !event_type.contains("SKIP")) {
                    manual_ffr += (content_end - content_start);
                }
            }

        }
        // ************ for Vod events
        else if (prev_viewing_type.equalsIgnoreCase("VODEvent")) {

            if (ruid != null)
                if (!prev_ruid.equalsIgnoreCase(ruid)) {
                    if (!prev_event_type.equalsIgnoreCase("DVR_EOE")) {
                        output = setOutput(output, prev_acc_id, prev_rec_id, prev_tuner, prev_channel,
                                prev_show_name, prev_tmsId, prev_viewing_type, prev_event_type, prev_channelFamily,
                                prev_ruid, prev_suid, prev_timeStarted, prev_timeEnded, prev_datecreated,
                                prev_content_start, prev_content_end, vod_time_watched, manual_ffx, manual_ffr);
                        ae.outputResult(output);
                    }
                    vod_time_watched = 0;
                    manual_ffr = 0;
                    manual_ffx = 0;
                    setPreviousValues();

                }
            if (event_type != null && content_start != 0 && content_end != 0) {
                // ******* total play time
                if (event_type.equalsIgnoreCase("DVR_PLAY") || event_type.equalsIgnoreCase("DVR_PAUSE")) {
                    vod_time_watched += (content_end - content_start);
                    // play_end = row.getCONTENT_END_EPOCH();
                }
                // ********* total ffx time
                if (event_type.contains("FWD_START") && !event_type.contains("SKIP")) {
                    manual_ffx += (content_end - content_start);
                }
                // ********** total ffr time
                if (event_type.contains("FWD_END") && !event_type.contains("SKIP")) {
                    manual_ffr += (content_end - content_start);
                }
            }

        }

    }
    return 0;
}

/**
 * 
 */
private static void setPreviousValues() {

    prev_acc_id = acc_id;
    prev_rec_id = rec_id;
    prev_tuner = tuner;
    prev_channel = channel;
    prev_show_name = show_name;
    prev_tmsId = tmsId;
    prev_viewing_type = viewing_type;
    prev_event_type = event_type;
    prev_channelFamily = channelFamily;
    prev_ruid = ruid;
    prev_suid = suid;
    prev_timeStarted = timeStarted;
    prev_timeEnded = timeEnded;
    prev_datecreated = datecreated;
    prev_content_start = content_start;
    prev_content_end = content_end;
}

/**
 * @param output
 * @param accId
 * @param recId
 * @param string
 * @param channel
 * @param showName
 * @param tmsId
 * @param eventName
 * @param eventType
 * @param channelFamily
 * @param ruid
 * @param suid
 * @param timeStarted
 * @param timeEnded
 * @param fieldAsTimestamp2
 * @param contentStart
 * @param contentEnd
 * @param duration
 * @param manualFfx
 * @param manualFfr
 */
private static NzaeRecord setOutput(NzaeRecord output, String accId, String recId, String string, String channel,
        String showName, String tmsId, String eventName, String eventType, String channelFamily, String ruid,
        int suid, double timeStarted, double timeEnded, Timestamp fieldAsTimestamp2, double contentStart,
        double contentEnd, double duration, double manualFfx, double manualFfr) {
    output.setField(0, accId);
    output.setField(1, recId);
    output.setField(2, string);
    output.setField(3, channel);
    output.setField(4, showName);
    output.setField(5, tmsId);
    output.setField(6, eventName);
    output.setField(7, eventType);
    output.setField(8, channelFamily);
    output.setField(9, ruid);
    output.setField(10, suid == 0 ? null : suid);
    output.setField(11, timeStarted == 0 ? null : timeStarted);
    output.setField(12, timeEnded == 0 ? null : timeEnded);
    output.setField(13, fieldAsTimestamp2);
    output.setField(14, contentStart == 0 ? null : contentStart);
    output.setField(15, contentEnd == 0 ? null : contentEnd);
    output.setField(16, duration);
    output.setField(17, manualFfx);
    output.setField(18, manualFfr);
    return output;

}

/**
 * @param meta
 */
private static void validateInput(NzaeMetadata meta) {
    if (meta.getOutputColumnCount() != 19) {
        throw new NzaeException("expecting  19 output columns ");
    }
    if (meta.getInputColumnCount() != 16) {
        throw new NzaeException("expecting 16 input columns");
    }
    if (meta.getInputNzType(0) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(0) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("first input column (Account id hashed) expected to be a string type");
    }
    if (meta.getInputNzType(1) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(1) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("second input column (Receiver id hashed) expected to be a string type");
    }
    if (meta.getInputNzType(2) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(2) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("third input column (Tuner) expected to be a string type");
    }
    if (meta.getInputNzType(3) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(3) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("fourth input column (Channel) expected to be a string type");
    }
    if (meta.getInputNzType(4) != NzaeDataTypes.NZUDSUDX_NATIONAL_FIXED
            && meta.getInputNzType(4) != NzaeDataTypes.NZUDSUDX_NATIONAL_VARIABLE) {
        throw new NzaeException("fifth input column (Show name) expected to be a string type");
    }

    if (meta.getInputNzType(5) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(5) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("sixth input column (TMS_ID) expected to be a string type");
    }
    if (meta.getInputNzType(6) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(6) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("seventh input column (Event Name) expected to be a string type");
    }
    if (meta.getInputNzType(7) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(7) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("eighth input column (Event type) expected to be a string type");
    }
    if (meta.getInputNzType(8) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(8) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("nineth input column (CHANNEL_FAMILY) expected to be a string type");
    }
    if (meta.getInputNzType(9) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(9) != NzaeDataTypes.NZUDSUDX_VARIABLE) {
        throw new NzaeException("thenth input column (RUID) expected to be a string type");
    }
    if (meta.getInputNzType(10) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(10) != NzaeDataTypes.NZUDSUDX_INT32) {
        throw new NzaeException("eleventh input column (SUID) expected to be a integer type");
    }
    if (meta.getInputNzType(11) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(11) != NzaeDataTypes.NZUDSUDX_INT64) {
        throw new NzaeException("twelfth input column (Start Epoch) expected to be a Big Integer type");
    }
    if (meta.getInputNzType(12) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(12) != NzaeDataTypes.NZUDSUDX_INT64) {
        throw new NzaeException("thirteenth  input column (End Epoch) expected to be a Big Integer type");
    }
    if (meta.getInputNzType(13) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(13) != NzaeDataTypes.NZUDSUDX_TIMESTAMP) {
        throw new NzaeException("fourteenth input column (Date created) expected to be a timestamp type");
    }
    if (meta.getInputNzType(14) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(14) != NzaeDataTypes.NZUDSUDX_INT64) {
        throw new NzaeException("fifteenth input column (Content start date) expected to be a Big Integer type");
    }
    if (meta.getInputNzType(15) != NzaeDataTypes.NZUDSUDX_FIXED
            && meta.getInputNzType(15) != NzaeDataTypes.NZUDSUDX_INT64) {
        throw new NzaeException("sixteenth input column (Content end date) expected to be a big Integer type");
    }
}