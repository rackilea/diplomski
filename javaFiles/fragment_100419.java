activityListener = {

    timeout: null,

    activityHandler: function () {
        $.cookie('last_activity', new Date().getTime());
    },

    initialize: function (timeout) {
        this.timeout = timeout;
        $.cookie('last_activity', new Date().getTime());
        if ($.cookie('do_activity_check') != true) {
            $.cookie('do_activity_check', true);
            setInterval(this.activityCheck, timeout / 2);
        }
        addEventListener('click', this.activityHandler, false);
        addEventListener('scroll', this.activityHandler, false);
    },

    handleTimeout: function () {
        if (oLoginPage.authorities != null) {
            le.send({
                "@class": "UserRequest$Logout",
                "id": "UserRequest.Logout"
            });
        }
    },

    activityCheck: function () {
        var after_last_activity_ms = new Date().getTime() - $.cookie('last_activity');
        if (after_last_activity_ms > activityListener.timeout) activityListener.handleTimeout();
    }
}