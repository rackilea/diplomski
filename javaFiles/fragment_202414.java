case LOGIN_TASK:
    mListener.callback(loginNetworkHelper);
    break;

default:
    Log.e(TAG, "Unknown task type: " + taskType.getTaskType());
    error.setError(ErrorHelper.error.UNKNOWN_ERROR);
    mListener.callback(new NetworkHelper(error));