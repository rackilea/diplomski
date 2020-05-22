<?php
class AtRiskApi extends SugarApi
{
    // This function is only called whenever the rest service cache file is deleted.
    // This shoud return an array of arrays that define how different paths map to different functions
    public function registerApiRest() {
        return array(
            'getAtRisk' => array(
                // What type of HTTP request to match against, we support GET/PUT/POST/DELETE
                'reqType' => 'GET',
                // This is the path you are hoping to match, it also accepts wildcards of ? and <module>
                'path' => array('Accounts', 'at_risk'),
                // These take elements from the path and use them to populate $args
                'pathVars' => array('', ''),
                // This is the method name in this class that the url maps to
                'method' => 'getAtRisk',
                // The shortHelp is vital, without it you will not see your endpoint in the /help
                'shortHelp' => 'Lists at risk accounts in the system',
                // The longHelp points to an HTML file and will be there on /help for people to expand and show
                'longHelp' => '',
            ),
        );
    }

    function getAtRisk($api, $args)
    {
        // Start off with something simple so we can verify the endpoint is registered.
        return 'burgers';
    }
}